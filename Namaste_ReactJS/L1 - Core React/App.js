
// tag -- attribute -- children
const headi = React.createElement("h1", {id: "heading", xyz: 2}, `Hello World by React CDN`)
console.log(headi)

const rooti = ReactDOM.createRoot(document.getElementById("root"))

// refresh root element only.
rooti.render(headi)


// Lesson 7 - Html Struct with React
/*
create this structure using React
<div id="parent">
    <div id="child">
        <h1>Child's Friend</h1>
    <div>
</div>
*/

const parent = React.createElement(
    "div", {id: "parent"},
    React.createElement(
        "div", {id: "child"},
        // Lesson 8 - Multi Children
        [
            React.createElement("h1", {}, "Child's Friend 1"),
            React.createElement("h2", {}, "Child's Friend 2")
        ]
    )
)

rooti.render(parent)
