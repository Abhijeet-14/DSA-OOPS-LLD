import React from 'react'
import ReactDOM from 'react-dom'

const rooti = ReactDOM.createRoot(document.getElementById("root"))

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