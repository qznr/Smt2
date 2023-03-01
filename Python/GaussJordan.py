import numpy as np

if __name__ =='__main__':
    number_of_variables = int(input("Masukkan berapa jumlah variabel : "))
    equation = []
    for i in range(number_of_variables):
        equation.append(list(map(int,input("Masukkan koefisien dan konstanta : ").split())))
    equation_system = np.array(equation)
    print(equation_system)