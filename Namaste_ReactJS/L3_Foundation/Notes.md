# Notes
1. React.createElement(tag, attr, children) ?
   > it is a Object --> when render in DOM --> it become HTML Element
2. JSX? 
    > not HTML in JS
    > HTML like syntax
    > const jsxHeading = <h1 id="heading">This is React using JSX</h1>
3. we write React.createElement -- JSX does the same
   > Now on, use 'JSX' only.

4. JSX -> Babel transpiles to -> React.createElement -> React-JS Object -> after render -> HTML Element
   > React Element
   > const heading = (<h1 className="h1" tabIndex="2">Hey JSX</h1>)
