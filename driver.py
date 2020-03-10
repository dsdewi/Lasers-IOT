import csv
CutVsEng = str("")
Material = str("")
Passes = int(0)
Power = int(0)
Speed = int(0)
Material = input("Enter what material you are cutting: ")
Material = Material.lower()
while (CutVsEng != "cutting" or CutVsEng != "engraving"):
    CutVsEng = input("Are you cutting or engraving: ")
    if (CutVsEng == "cutting" or CutVsEng == "engraving"):
       break
while (Speed <= 0):
    Speed = input("What is your desired speed?: ")
    Speed = int(Speed)
while (Passes <= 0):
    Passes = input("How many passes would you like: ")
    Passes = int(Passes)
while (Power <= 0 or Power > 100):
    Power = input("At what power would you like to cut: ")
    Power = int(Power)
with open('testdata2.csv', 'w', newline='') as file:
    writer = csv.writer(file)
    writer.writerow([Material, CutVsEng, Speed, Passes, Power])
