app = Flask(__name__)
app.config['SECRET_KEY'] = os.environ.get('SECRET_KEY')
app.config['UPLOAD_FOLDER'] = os.environ.get('UPLOAD_FOLDER', 'static/uploads')
app.config['DATA_FOLDER'] = os.environ.get('DATA_FOLDER', 'data')

os.makedirs(app.config['UPLOAD_FOLDER'], exist_ok=True)
os.makedirs(app.config['DATA_FOLDER'], exist_ok=True)

class JSONProductStorage:


    def __init__(self, filename='products.json'):
        self.filename = os.path.join(app.config['DATA_FOLDER'], filename)
        self._ensure_file_exists()

    def _ensure_file_exists(self):

        if not os.path.exists(self.filename):
            with open(self.filename, 'w') as f:
                json.dump([], f)

    def read_all(self):
        try:
            with open(self.filename, 'r') as f:
                return json.load(f)
        except (json.JSONDecodeError, FileNotFoundError):
            return []

    def write_all(self, products):
        with open(self.filename, 'w') as f:
            json.dump(products, f, indent=4, default=str)

    def get_next_id(self):
        products = self.read_all()
        if not products:
            return 1
        return max(product.get('id', 0) for product in products) + 1

    def get_all(self):
        return self.read_all()

    def get_by_id(self, product_id):
        products = self.read_all()
        for product in products:
            if product.get('id') == product_id:
                return product
        return None

    def add(self, product_data):
        products = self.read_all()

        product = {
            'id': self.get_next_id(),
            'title': product_data.get('title', ''),
            'price': float(product_data.get('price', 0)),
            'description': product_data.get('description', ''),
            'image_filename': product_data.get('image_filename')
        }

        products.append(product)
        self.write_all(products)
        return product


    def delete(self, product_id):
        products = self.read_all()

        for i, product in enumerate(products):
            if product.get('id') == product_id:

                removed_product = products.pop(i)
                self.write_all(products)

                if removed_product.get('image_filename'):
                    image_path = os.path.join(
                        app.config['UPLOAD_FOLDER'],
                        removed_product['image_filename']
                    )
                    if os.path.exists(image_path):
                        os.remove(image_path)

                return True

        return False

storage = JSONProductStorage()


def allowed_file(filename):
    """Check if file extension is allowed"""
    ALLOWED_EXTENSIONS = {'png', 'jpg', 'jpeg', 'gif'}
    return '.' in filename and filename.rsplit('.', 1)[1].lower() in ALLOWED_EXTENSIONS

def save_uploaded_file(file):
    """Save uploaded file and return filename"""
    if file and file.filename != '' and allowed_file(file.filename):
        # Secure the filename
        filename = secure_filename(file.filename)

        # Add timestamp for uniqueness
        timestamp = datetime.now().strftime('%Y%m%d_%H%M%S')
        name, ext = os.path.splitext(filename)
        filename = f"{timestamp}_{name}{ext}"

        # Save file
        filepath = os.path.join(app.config['UPLOAD_FOLDER'], filename)
        file.save(filepath)

        return filename
    return None


@app.route('/')
@app.route('/products')
def list_products():
    products = storage.get_all()
    return render_template('products.html', products=products)

@app.route('/product/<int:id>')
def product_detail(id):
    product = storage.get_by_id(id)

    if not product:
        flash('Product not found!', 'error')
        return redirect(url_for('list_products'))

    return render_template('product_detail.html', product=product)

@app.route('/create', methods=['GET', 'POST'])
def create_product():
    if request.method == 'POST':
        title = request.form.get('title', '').strip()
        price = request.form.get('price', '')
        description = request.form.get('description', '')

        errors = []
        if not title:
            errors.append('Product title is required')
        if not price:
            errors.append('Price is required')
        else:
            try:
                price = float(price)
                if price < 0:
                    errors.append('Price cannot be negative')
            except ValueError:
                errors.append('Price must be a number')

        if errors:
            for error in errors:
                flash(error, 'error')
            return render_template('create.html')

        image_filename = None
        if 'image' in request.files:
            file = request.files['image']
            image_filename = save_uploaded_file(file)

        product_data = {
            'title': title,
            'price': price,
            'description': description,
            'image_filename': image_filename
        }

        product = storage.add(product_data)

        flash(f'Product "{title}" added successfully!', 'success')
        return redirect(url_for('product_detail', id=product['id']))

    return render_template('create.html')

@app.route('/delete/<int:product_id>')
def delete_product(product_id):
    success = storage.delete(product_id)

    if success:
        flash('Product deleted successfully!', 'success')
    else:
        flash('Product not found!', 'error')

    return redirect(url_for('list_products'))

if __name__ == '__main__':
    app.run(debug=True)
