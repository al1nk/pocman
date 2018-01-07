# coding=utf-8
import numpy as np
import matplotlib.pyplot as plt


def parse_file(filename):
    try:
        rawData = open("../output/" + filename + ".pltdt", "r")
    except IOError as e:
        print(e.strerror)
        print("File : " + filename)
        return False

    data = []
    for line in rawData:
        data.append([int(i) for i in line[1:-2].split(', ')])

    rawData.close()

    return data


def plot_data(data, filename):
    if not data:
        return

    plt.figure(filename)
    plt.title(filename)
    plt.plot(data[0], data[1], label="Deaths")
    plt.plot(data[0], data[2], label="Réc.")
    plt.plot(data[0], data[3], label="Murs")

    plt.legend()
    plt.show()


qlearn = parse_file("QLearning")
sarsa = parse_file("SARSA")
rnd = parse_file("none")

plot_data(qlearn, "QLearning")
plot_data(sarsa, "SARSA")
plot_data(rnd, "none")
