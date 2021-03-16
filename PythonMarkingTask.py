#Hi. When calling class methods outside of a class it depends on whether you're *instantiating* an object
#(please ask for help if you don't know what this means).. When you instantiate an object, you store a version of it
#in a variable then you call the methods in the form variable.method(params).

#In order to just invoke methods of an class without instantiating an object, you just call the method in the form
#className.method(params).

#I have some notes for you on you implementation of your code:


#Comments and class declarations cannot be on the same line.
# An SMS Simulation class SMSMessage(object):
#Pay attention to indentation when declaring classes and methods. Please ask for help on this if you need it.
hasBeenRead = False messageText = text fromNumber = number
def __init__(self,hasBeenRead,messageText,fromNumber):
    #Variable declarations cannot be on the same line unless they are separated with a semi-colon (;).
    self.hasBeenRead = False self.messageText = text self.fromNumber = fromNumber

#function names should be in lower case, with each word [separated_by_an_underscore]. This is the convention in Python
def MarkASRead(self):
    #You may have forgotten to use quotes for declaring strings
    if userChoice == read:
        self.hasBeenRead = True

def add_sms():
def get_count():
#again, your function name should be in lowercase, with each word separated by an underscore
def get_Message():
def get_unread_messages():
def remove():


# you have to specify your parameters in your class declaration, using object as a keyword only works for passing
# an instantiated object.
no_1 = SMSMessage(False, "Hello", "0798653452")
no_2 = SMSMessage(False, "WYD", "0845673864")
no_3 = SMSMessage(False, "How are you?", "0631873298")

#please remember to either declare each variable on a new line, or seperate them with a semicolon.
SMSStore = [] userChoice = ""

while userChoice != "quit":
    #raw_input() was changed to input() in Python 3
    userChoice = raw_input("What would you like to do - read/send/quit?")
    if userChoice == "read":
        #Please state if you need help with this section
        #Place your logic here elif userChoice == "send": #Place your logic here elif userChoice == "quit":
        print("Goodbye")
    else:
        print("Oops - incorrect input")