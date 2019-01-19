/**
 * Created by admin on 19.01.2019.
 */
function writeCheers(conf) {
    if(conf=="confirmation")
        alert("Punkt został dodany!")
    else if (conf=="warning")
        alert("Wystąpił błąd! Spróbuj ponownie")
}

function afterChoiceRoute() {
    alert("Trasa została wybrana, możesz ją przeglądać w panelu tras")

}