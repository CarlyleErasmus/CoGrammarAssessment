#Hi, student, please follow the comments below to see exactly where you went wrong.

#below the class was declared in a comment line and so Python does not recognise it.
#An SMS Simulation class SMSMessage(object): 

#the below block of code was not indented and so it is not recognised as being part of the class. Also each variable has to be declared on its own line unless seperated by a semi-colon (;).
hasBeenRead = False messageText = text fromNumber = number
def __init__(self,hasBeenRead,messageText,fromNumber):
    #again, each variable has to be declared on its own line unless seperated by semi colon.
    self.hasBeenRead = False self.messageText = text self.fromNumber = number
    
def MarkASRead(self):
    if userChoice == read:
        self.hasBeenRead = True
        
def add_sms():
def get_count():
def get_message():
def get_unread_messages():
#each function falling within the class should be indented under the class.
def remove():
    
    
#below you are passing parameters as arguments of the boolean and string type into the SMSMessage object, but in its class you declared an object type which means you will have to concider what you declared as a parameter to be passed in declaring your class.
no_1 = SMSMessage(False, "Hello", "0798653452")
no_1 = SMSMessage(False, "WYD", "0845673864")
no_1 = SMSMessage(False, "How are you?", "0631873298")