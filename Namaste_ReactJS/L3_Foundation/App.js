import React from "react";
import ReactDOM from "react-dom";

// Normal React Element
const heading = React.createElement("h1", { id: "heading" }, "Namaste React");
const root = ReactDOM.createRoot(document.getElementById("root"));
// root.render(heading)

// React Element - with JSX
const jsxHeading = (
  <h1 className="h1" tabIndex="2">
    NR with JSX
  </h1>
);
// root.render(jsxHeading)

const Title = () => (<h1>Title Title</h1>)

// React Components
const HeadingComponent = () => (
  <div id="container">
    {100 + 200} {/* Write any JS inside curly bracket '{}' */}
    {Title()}
    <Title></Title>
    <Title />
    <h1 className="heading">Namaste React Functional Component</h1>
  </div>
);

// Render Functional Component
root.render(<HeadingComponent />);
// <COMP />  - bable understand this is React Component
