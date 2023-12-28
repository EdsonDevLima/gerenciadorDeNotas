interface Igrades{
    var n1:Float
    var n2:Float
    var n3:Float
    var n4:Float
    var name:String
}
data class DataStudent( var n1:Float, var n2:Float, var n3:Float, var n4:Float, var name:String,var media:Float)

class ControllerGrades{
    var nota1:Float = 0f
    var nota2:Float = 0f
    var nota3:Float = 0f
    var nota4:Float = 0f
    var name:String = ""
    var media:Float = 0f
    var yesOrNo:String = ""
    lateinit var dataStudent:List<DataStudent>
      fun registerGrades(){
        println("voce possui todas as 4 notas do ano? se sim digite ${"sim"}, se nao digite ${"nao"}" )
        yesOrNo = readln()
         if (yesOrNo != "sim" && yesOrNo != "nao"){
             println("existem duas alternativas sim ou nao")
             println("digite novamente:")
             yesOrNo = readln()
         }
         else{
             if (yesOrNo == "nao"){
                 println("programa finalizado")
                 return

             }
             else if(yesOrNo == "sim"){
                 try {
                     println("digite a primeira nota")
                     nota1  = readln().toFloat()
                 }catch (e:Exception){
                    println("nota invalida, digite novamente")
                     nota1  = readln().toFloat()
                 }
                 try {
                     println("digite a segunda nota")
                     nota2  = readln().toFloat()
                 }catch (e:Exception){
                     println("nota invalida, digite novamente")
                     nota2  = readln().toFloat()
                 }
                 try {
                     println("digite a terceira nota")
                     nota3  = readln().toFloat()
                 }catch (e:Exception){
                     println("nota invalida, digite novamente")
                     nota3 = readln().toFloat()
                 }
                 try {
                     println("digite a quarta nota")
                     nota4  = readln().toFloat()
                 }catch (e:Exception){
                     println("nota invalida, digite novamente")
                     nota4  = readln().toFloat()
                 }
                 println("e por fim digite o seu nome")
                 name = readln()
                 media = nota1 + nota2 + nota3 + nota4 / 4
                 dataStudent = listOf(DataStudent(nota1,nota2,nota3,nota4,name,media))

             }//condiçao do else

         }//condiçao do if

    }//final do funçao register
    fun displayAllStudents(){

        println("Aqui estao as notas de todos o alunos cadastrados")
        dataStudent.forEach { println( "Aluno: (${it.name}) primeira (${it.n1}),segunda (${it.n2}),terceira (${it.n3}),quarta (${it.n4}) ,media ${it.media} ") }
    }//final displayAllStudents
    fun alterGrades(){
        var StudentGrade:String
        println("escolha o nome do aluno que voce quer alterar")
        var StudentName:String = readln()
        var filterStudent = dataStudent.filter { it.name == StudentName }
        if(filterStudent[0].name != StudentName){
            println("esse nome nao foi encontrado,digite outro nome")
            StudentName = readln()
        }
        try {
            println("qual notas voce quer alterar? nota1,nota2,nota3 ou nota4?")
             StudentGrade = readln()
        }catch (e:Exception){
            println("esse nota nao é valida, digite novamente")
            StudentGrade = readln()
        }
        if (StudentGrade != "nota1" && StudentGrade != "nota2" && StudentGrade != "nota3" && StudentGrade != "nota4"){
            println("esse nota nao é valida, digite novamente")
            StudentGrade = readln()
        }
        if (StudentGrade != "nota1"){

        }
        if (StudentGrade != "nota2"){}
        if (StudentGrade != "nota3"){}
        if (StudentGrade != "nota4"){}


    }//final da alterStudent



}//final da classe

fun main(){
val ControllerStudents = ControllerGrades()
    ControllerStudents.registerGrades()
    ControllerStudents.displayAllStudents()
    ControllerStudents.alterGrades()
}