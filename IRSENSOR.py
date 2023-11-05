# import RPi.GPIO as gpio
# import time

# gpio.setmode(gpio.BCM)

# gpio.setup(3,gpio.IN)

# count=0

# while True:
#     state=gpio.input(3)

#     if state==0:
#         count=count+1
#         print("count is",count)
#         time.sleep(0.2)
#     else:
#         continue





import RPi.GPIO as gpio
import time

pin=5

high=True
low=False
def initSystem():
    gpio.setmode(gpio.BCM)
    gpio.setup(pin,gpio.IN,pull_up_down=gpio.PUD_UP)
    return


def detectPerson():
    while True:
        state=gpio.input(pin)
        time.sleep(0.3)
        if(state==0):
            return low
        else:
            return high

try:
    initSystem()

    count=0

    while True:
        state=detectPerson()

        if state==high:
            count+=1
            print("count is:",count)
except  keyboardInterupt:
    print("keyboard intrupt")

finally:
    gpio.cleanup()
