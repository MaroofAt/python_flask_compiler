import os   

basedir = os.path.abspath(os.path.dirname(__name__))

SECRET_KEY = os.environ.get('SECRET_KEY') or 'dev-secret-key-change-in-production'