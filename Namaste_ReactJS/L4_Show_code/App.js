import React from "react";
import ReactDOM from "react-dom/client";

/**
 * Wireframe
 *  Header
 *    - Logo
 *    - Nav Items
 *  Body
 *    - Search
 *    - Restaurant Container
 *      - Resto Card
 *        - Image
 *        - Content
 *        - Rating
 *  Footer
 *    - Copyright
 *    - Link
 *    - Address
 *    - Contact
 */

const Header = () => {
  return (
    <div className="header">
      <div className="logo-container">
        <img
          className="logo"
          src="https://i.pinimg.com/originals/59/5f/a5/595fa5ffb3d67f62ceabaa0d9a40d1e2.png"
          alt="LOGO"
        />
      </div>
      <div className="nav-items">
        <ul>
          <li>Home</li>
          <li>About</li>
          <li>Contact</li>
          <li>Cart</li>
        </ul>
      </div>
    </div>
  );
};


const Body = () => { return (<div className="body">body</div>)}
const Footer = () => { return (<div className="footer">footer</div>)}
const AppLayout = () => {
  return (
    <div className="App">
      <Header />
      <Body />
      <Footer />
    </div>
  );
};

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(<AppLayout />);
