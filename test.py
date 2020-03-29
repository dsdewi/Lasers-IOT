from sensor import *
import sys, time

temp_param_a = 0.1
temp_param_b = 0.2 #temporary constants for parameters
#TODO calibrate and refer to datasheet to change parameters accordingly


try:
    print("Press CTRL+C to abort.")
    
    mq2 = Sensor("MQ2", "Combustible Gas", temp_param_a, temp_param_b, 0)
    mq3 = Sensor("MQ3", "Alcohol", temp_param_a, temp_param_b, 1)
    mq4 = Sensor("MQ4", "Methane and Natural Gas", temp_param_a, temp_param_b, 2)
    mq5 = Sensor("MQ5", "LPG and Natural Gas", temp_param_a, temp_param_b, 3)
    mq7 = Sensor("MQ7", "Carbon Monoxide", temp_param_a, temp_param_b, 4)
    mq8 = Sensor("MQ8", "Hydrogen", temp_param_a, temp_param_b, 5)
    mq9 = Sensor("MQ9", "Carbon Monoxide and Methane", temp_param_a, temp_param_b, 6)
    mq135 = Sensor("MQ135", "Smoke", temp_param_a, temp_param_b, 7)

    while True:
        print("MQ2|{} : {}".format(mq2.substance, mq2.ppm))
        print("MQ3|{} : {}".format(mq3.substance, mq3.ppm)) 
        print("MQ4|{} : {}".format(mq4.substance, mq4.ppm)) 
        print("MQ5|{} : {}".format(mq5.substance, mq5.ppm)) 
        print("MQ7|{} : {}".format(mq7.substance, mq7.ppm)) 
        print("MQ8|{} : {}".format(mq8.substance, mq8.ppm)) 
        print("MQ9|{} : {}".format(mq9.substance, mq9.ppm)) 
        print("MQ135|{} : {}".format(mq135.substance, mq135.ppm)) 
        
        time.sleep(0.1)

except:
    print("\nAbort by user")