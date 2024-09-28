import React from 'react'
import ReactDOM from 'react-dom'

// React Element
const heading = (<h1 className="h1" tabIndex="2">Hey JSX</h1>)

// React Components
const HeadingComponent = () => (
    <div id = "container">
        <h1 className='heading'>Namste React Functional Component</h1>
    </div>
)

const root = ReactDOM.createRoot(document.getElementById("root"))
root.render(heading)

//  Render Functional Component
root.render(<HeadingComponent />)