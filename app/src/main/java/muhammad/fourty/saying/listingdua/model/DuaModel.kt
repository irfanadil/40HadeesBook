package muhammad.fourty.saying.listingdua.model


//@Entity(tableName = "quotesTable")
data class DuaModel(
    val stageIndex: Int,
    val duaTitle: String,
    val duaDayCount: String,
    //val duaBenefit: String? = "some dua benefit",
    var visibleState: Boolean = true,
    //@PrimaryKey(autoGenerate = true)
    //var autoId:Int = 0
)