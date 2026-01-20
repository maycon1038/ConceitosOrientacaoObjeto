class Serve {

   lateinit var db: Database

    fun  initServe(){
        if (!::db.isInitialized){
            db = Database()
        }
        db.openConexao()

    }
}