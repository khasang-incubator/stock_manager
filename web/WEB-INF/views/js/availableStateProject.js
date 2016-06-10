window.onload = getStateProject;

function getStateProject() {
    var stateProjectElement = new Array();
    stateProjectElement = document.getElementsByName('state');
    for(var i = 0; i < stateProjectElement.length; ++i) {
        var stateProjectText = stateProjectElement[i].options[0].text;
        addAvailableState(stateProjectElement[i], stateProjectText);
    }
}

function addAvailableState(stateProjectElement, stateProjectText) {
    if (stateProjectText != "process") {
        addOptionForSelect(stateProjectElement, "process");
    }
    if (stateProjectText != "complete") {
        addOptionForSelect(stateProjectElement, "complete");
    } 
}

function addOptionForSelect(stateProjectElement, text) {
    var oOption = document.createElement("option");
    oOption.appendChild(document.createTextNode(text));
    oOption.setAttribute("text", text);
    oOption.setAttribute("value", text);
    stateProjectElement.appendChild(oOption);
}