from flask_sqlalchemy import SQLAlchemy
from sqlalchemy.orm import Mapped, mapped_column
import os
from werkzeug.utils import secure_filename

db = SQLAlchemy()

class ProductModel (db.Model):
    __tablename__ = "products"

    id = db.Column(db.Integer , primary_key = True)
    title = db.Column(db.String(20))
    price = db.Column(db.Float())
    description = db.Column(db.Text())
    image_filename = db.Column(db.String(100))

    def save_uploaded_image(file):
        if file and file.filename != '':
            filename = secure_filename(file.filename)
            upload_path = os.path.join('static', 'uploads')
            os.makedirs(upload_path, exist_ok=True)
            file.save(os.path.join(upload_path, filename))
            return filename
        return None

    def __init__(self , title , price , description , image_filename):
        # super().__init__()
        self.title = title
        self.price = price
        self.description = description
        self.image_filename = image_filename
        def __repr__(self):
            return f"{self.title}"