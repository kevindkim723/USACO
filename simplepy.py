import os

def printfiles(path):
    print("DIRECTORY: " + path)
    for f in os.listdir(path):
        if (os.path.isdir(f)):
            printfiles(path+"/"+f)
        else:
            print(f);
printfiles(os.getcwd())
