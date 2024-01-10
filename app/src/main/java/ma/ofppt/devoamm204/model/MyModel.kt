package ma.ofppt.devoamm204.model

class MyModel : MVP.Model {
    val userList  = ArrayList<User>()
    var index = 0
    init {
        userList.add(User("prenom 1","nom 1"))
        userList.add(User("prenom 2","nom 2"))
        userList.add(User("prenom 3","nom 3"))
        userList.add(User("prenom 4","nom 4"))
        userList.add(User("prenom 5","nom 5"))

    }
}