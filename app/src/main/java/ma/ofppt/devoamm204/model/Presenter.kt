package ma.ofppt.devoamm204.model

class Presenter : MVP.Presenter,MVP.View.ViewEvent {
    val myModel = MyModel()
    lateinit var user : User
    lateinit var mainView : MVP.View
    override fun onGetNext() {
        myModel.index++
        user = myModel.userList[myModel.index]
        mainView.setUser(user)
    }

}