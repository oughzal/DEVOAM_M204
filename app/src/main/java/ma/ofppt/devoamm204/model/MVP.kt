package ma.ofppt.devoamm204.model

interface MVP {
    interface View{
        interface ViewEvent{
            fun onGetNext()
        }
        fun setUser(user: User)
    }
    interface Model{}

    interface Presenter{

    }
}