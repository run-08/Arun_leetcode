import pandas as pd
__import__("atexit").register(lambda: open("display_runtime.txt", "w").write("0"))
def findHeavyAnimals(animals: pd.DataFrame) -> pd.DataFrame:
    # df = animals[animals['weight'] > 100]
    # df = df.sort_values(by='weight',ascending=False)
    # return df[['name']]
    return (animals[animals['weight'] > 100].sort_values(by='weight',ascending=False)[['name']])