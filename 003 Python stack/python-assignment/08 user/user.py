class User:		# here's what we have so far
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.account_balance = 0
    # adding the deposit method
    def make_deposit(self, amount):
        self.account_balance += amount
        # print("User:",self.name,",","Balance:",self.account_balance,"$")
    def make_withdrawal(self, amount):	
        self.account_balance -= amount
        # print("User:",self.name,",","Balance:",self.account_balance,"$")
    def  transfer_money(self, other_user, amount) :
        self.account_balance -= amount
        other_user.account_balance += amount
        # print("User:",self.name,",","Balance:",self.account_balance,"$")
        # print("User:",other_user.name,",","Balance:",other_user.account_balance,"$")
    def display_user_balance(self):
        print("User:",self.name,",","Balance:",self.account_balance,"$")
masa = User("Masa Shabib","masa@yahoo.com")
marah = User("Marah Shabib","marah@yahoo.com")
mohammad= User("Mohammad Shabib","mohammad@yahoo.com")
# masa.make_deposit(100)
# masa.make_deposit(300)
# masa.make_deposit(200)
# masa.make_withdrawal(400)
# marah.make_deposit(100)
# marah.make_deposit(300)
# marah.make_withdrawal(400)
# marah.make_withdrawal(400)
masa.transfer_money(marah, 200)
masa.display_user_balance()