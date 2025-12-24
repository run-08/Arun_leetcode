import pandas as pd

def renameColumns(students: pd.DataFrame) -> pd.DataFrame:
    df = pd.DataFrame()
    df["student_id"] = students["id"]
    df["first_name"] = students["first"]
    df["last_name"] = students["last"]
    df["age_in_years"] = students["age"]
    return df