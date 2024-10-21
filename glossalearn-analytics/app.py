from flask import Flask
from psycopg2 import connect, extras
from os import environ

app = Flask(__name__)

@app.route("/api/v1/analyze")
def computeStudentAnalytics():
    try:
        conn = connect(database = environ.get('DB_DATABASE'),
                                host = environ.get('DB_HOST'),
                                user = environ.get('DB_USERNAME'),
                                password = environ.get('DB_PASSWORD'),
                                port = environ.get('DB_PORT'))
        cursor = conn.cursor(cursor_factory = extras.RealDictCursor)
        cursor.execute("SELECT COUNT(*) FROM lessons")
        result = cursor.fetchone()
        conn.commit()
        conn.close()
    except Exception as error:
        print(error)
        return {
            "type": "NO_LESSONS_ACCESS",
            "message": f"An error occured during lesson retreive"
        }

    return result