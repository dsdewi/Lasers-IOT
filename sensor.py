import spidev
import math

# Open SPI bus
spi = spidev.SpiDev()
spi.open(0,0)
spi.max_speed_hz=1000000


class Sensor:

    def __init__(self, param_a, param_b, channel=0, spi_port=0):
        self.param_a = param_a
        self.param_b = param_b
        self.channel = channel
        self.port = spi_port
        self.voltage = self.getVoltage()
        self.ratio = self.getResistanceRatio()
        self.ppm = self.calculatePPM()


    def getVoltage(self):
        adc = spi.xfer2([1, (8 + self.channel) << 4, 0])
        data = ((adc[1] & 3) << 8) + adc[2]
        volts = (data * 3.3) / float(1023)
        volts = round(volts, 3)         # Round off to 3 decimal places
        return volts                    #  get voltage from SPI

    def getResistanceRatio(self):
        #ro = sensor resistance at 100/1000ppm
        #rs = sensor resistance at varying concentrations
        ratio = (5.0 - self.voltage) / float(self.voltage) #get ro/rs ratio
        ratio = round(ratio, 3)                            #round off to 3dp
        return ratio

    def calculatePPM(self):
        rs_ro = self.ratio
        ppm = self.param_a * math.pow(rs_ro, self.param_b)
        return ppm


'''
# A test function
if __name__ == '__main__':
    mq2 = Sensor(['MQ-2', temperature, humidity, consta, constb], 0, 4)
    mq3 = Sensor
    ppm = mq2.ppm
    while mq3.ppm < value: 
        do something
        
        
put data in csv file
'''
'''
Things we want to put in the parameters vector

    - Mode of calculation/name of sensor
    - Fundamental constants
        Log-log 
            Slope = ppm dependency
            Intercept = clean air reading
        Linear (temperature/humidity dependence)
            p1 (Temperature)
            p2 (Humidity)    
'''



