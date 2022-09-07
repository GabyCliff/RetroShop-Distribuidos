import bg1 from '../img/backgrounds/bg1.jpeg';
import bg2 from '../img/backgrounds/bg2.jpeg';
import bg3 from '../img/backgrounds/bg3.jpeg';
import bg4 from '../img/backgrounds/bg4.jpeg';
import bg5 from '../img/backgrounds/bg5.jpeg';
import bg6 from '../img/backgrounds/bg6.jpeg';

const LIST_BACKGROUNDS = [{
    "name":"bg1",
    "image":bg1
}, {
    "name":"bg2",
    "image":bg2
}, {
    "name":"bg3",
    "image":bg3
}, {
    "name":"bg4",
    "image":bg4
},{
    "name":"bg5",
    "image":bg5
},{
    "name":"bg6",
    "image":bg6
}];

export function getBackground(){
    let background = sessionStorage.getItem("background");
    if(background === null){
        background = LIST_BACKGROUNDS[Math.floor(Math.random() * LIST_BACKGROUNDS.length)];
        sessionStorage.setItem("background", background["name"]);
    } else {
        background = LIST_BACKGROUNDS.find(x => x.name === background);
    }

    return background["image"];

}