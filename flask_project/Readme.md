# How to run project
 1. create ur own venv: inside the flask_project folder [ < Python 3.13 path > -m venv venv  ]
 2. install the requirements: pip install -r requirements.txt
 3. copy .env.example to .env file on ur device using terminal: cp .env.example .env (Note: use powershell instead of cmd on windows and 'copy' will work)
 4. generate Secret Key using [Djecrety](https://djecrety.ir) website, and place it in .env file
 5. in powershell write `flask run` and now project running 😊