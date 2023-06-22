package muhammad.renowned.saying.listinghadees.model


//@Entity(tableName = "quotesTable")
data class SayingIndexModel(
    val stageIndex: Int,
    val hadeesTitle: String,
    val duaDayCount: String,
    //val duaBenefit: String? = "some dua benefit",
    var visibleState: Boolean = true,
    //@PrimaryKey(autoGenerate = true)
    //var autoId:Int = 0
)