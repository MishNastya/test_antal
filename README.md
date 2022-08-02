@Entity
data class TestEntity(
    @Id
    val id:UUID? = null,
    val documentId:UUID? = null,
    val documentDate:String? = null,
    val dictionaryValueId: UUID? = null,
    val dictionaryValueName: UUID? = null,
    val sortOrder: String? = null
){
    var testId: UUID? = null
    var testName: String = "Test"
}

Нужно критически взглянуть на указанную сущность и написать мини-эссе на тему "что вызывает вопросы"
затем написать на kotlin модуль с liquibase-скриптом, создающим данную таблицу (в усовершенствованном после собственных размышлений виде) с одним контроллером,
включающим CRUD-операции над указанной сущностью (методы GET, POST, PATCH, DELETE) с использованием spring-data-jpa
