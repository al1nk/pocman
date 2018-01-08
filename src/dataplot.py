# coding=utf-8
import numpy as np
import matplotlib.pyplot as plt


def parse_file(filename):
    """
    Parses file of given name
    :param filename: name of the file to parse
    :return: dataset
    """
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


def plot_data(data, filename, smoothen=True):
    """
    Plot the data (to an output PNG file)
    :param data: dataset to plot
    :param filename: name of the considered file
    :param smoothen: if the curve should be smoothen out
    """
    if not data:
        return

    deaths = data[1]
    cheeses = data[2]
    walls = data[3]

    plt.figure(filename)
    plt.title(filename)
    plt.plot(smooth_out(deaths, 15) if smoothen else deaths, label="Deaths")
    plt.plot(smooth_out(cheeses, 15) if smoothen else cheeses, label="Réc.")
    plt.plot(smooth_out(walls, 15) if smoothen else walls, label="Murs")

    plt.ylim(0,)

    plt.xlabel("Epochs (* 5e3)")
    plt.ylabel("Number of ...")

    plt.legend()
    plt.savefig("../output/" + filename + ".png")

def smooth_out(dataset, mean_radius):
    """
    Smoothing out dataset by calculating the rolling average
    :param dataset: values to smoothen
    :param mean_radius: the radius of the rolling interval
    :return: smoothen dataset
    """
    ret = []
    for index in range(mean_radius, len(dataset) - mean_radius):
        average = np.mean(dataset[index - mean_radius:index + mean_radius + 1])
        ret.append(average)
    return ret


if __name__ == '__main__':
    
    # qlearn = parse_file("QLearning")
    # sarsa = parse_file("SARSA")
    # rnd = parse_file("none")
    #
    # plot_data(qlearn, "QLearning")
    # plot_data(sarsa, "SARSA")
    # plot_data(rnd, "none")
