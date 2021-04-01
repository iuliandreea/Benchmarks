import pandas as pd
import csv
import matplotlib.pyplot as plt
import sys

def plot_all_three():
    cplus = sys.argv[1]
    jav = sys.argv[2]
    pyth = sys.argv[3]

    df1 = pd.read_csv(str(cplus), skiprows=9)
    df11 = df1[['name', 'real_time']]
    df11 = df11.rename(columns={'name': 'name', 'real_time': 'time'})

    df2 = pd.read_csv(str(jav))
    df21 = df2[['Benchmark', 'Score', 'Param: noOfElements']]
    df21['Benchmark'] = df21['Benchmark'] + df21['Param: noOfElements'].apply(lambda x: "-" + str(x))
    df21 = df21[['Benchmark', 'Score']]
   # df21 = df2[['Benchmark', 'Score']]
    df21 = df21.rename(columns={'Benchmark': 'name', 'Score': 'time'})

    df3 = pd.read_csv(str(pyth))
    df31 = df3[['name', 'duration']]
    df31 = df31.rename(columns={'name': 'name', 'duration': 'time'})

    frame = df11.append(df21).append(df31)
    frame = frame.sort_values(by='time', ascending=True)

    frame.to_csv('result.csv', index=False)

    x = frame['name'].astype(str)
    y = frame['time'].astype(str)
    plt.figure(figsize=(15, 15))
    plt.xticks(rotation=90)
    plt.bar(x, y, width=2.0, color=['blue', 'purple', 'grey', 'cyan', 'pink'])
    plt.savefig(sys.argv[4], bbox_inches='tight')
    plt.show()


def plot_c():
    cplus = sys.argv[1]

    df1 = pd.read_csv(str(cplus), skiprows=9)
    df11 = df1[['name', 'real_time']]
    df11 = df11.rename(columns={'name': 'name', 'real_time': 'time'})
    df11 = df11.sort_values(by='time', ascending=True)

    x = df11['name'].astype(str)
    y = df11['time'].astype(str)
    plt.figure(figsize=(15, 15))
    plt.xticks(rotation=90)
    plt.bar(x, y, width=2.0, color=['blue', 'purple', 'grey', 'cyan', 'pink'])
    plt.savefig(sys.argv[2], bbox_inches='tight')
    plt.show()


def plot_java():
    jav = sys.argv[1]

    df2 = pd.read_csv(str(jav))
    # df21 = df2[['Benchmark', 'Score', 'Param: noOfElements']]
    # df21['Benchmark'] = df21['Benchmark'] + df21['Param: noOfElements'].apply(lambda x: "-" + str(x))
    # df21 = df21[['Benchmark', 'Score']]
    df21 = df2[['Benchmark', 'Score']]
    df21 = df21.rename(columns={'Benchmark': 'name', 'Score': 'time'})
    df21 = df21.sort_values(by='time', ascending=True)

    x = df21['name'].astype(str)
    y = df21['time'].astype(str)
    plt.figure(figsize=(15, 15))
    plt.xticks(rotation=90)
    plt.bar(x, y, width=2.0, color=['blue', 'purple', 'grey', 'cyan', 'pink'])
    plt.savefig(sys.argv[2], bbox_inches='tight')
    plt.show()


def plot_python():
    pyth = sys.argv[1]

    df3 = pd.read_csv(str(pyth))
    df31 = df3[['name', 'duration']]
    df31 = df31.rename(columns={'name': 'name', 'duration': 'time'})
    df31 = df31.sort_values(by='time', ascending=True)

    x = df31['name'].astype(str)
    y = df31['time'].astype(str)
    plt.figure(figsize=(15, 15))
    plt.xticks(rotation=90)
    plt.bar(x, y, width=2.0, color=['blue', 'purple', 'grey', 'cyan', 'pink'])
    plt.savefig(sys.argv[2], bbox_inches='tight')
    plt.show()


if __name__ == "__main__":

    if len(sys.argv) == 5:
        plot_all_three()

    if len(sys.argv) == 4:
        command = sys.argv[3]
        if command == '1':
            plot_c()
        if command == '2':
            plot_java()
        if command == '3':
            plot_python()