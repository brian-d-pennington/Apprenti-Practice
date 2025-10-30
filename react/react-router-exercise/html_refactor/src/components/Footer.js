import React, { Component } from 'react';

class Footer extends Component {
  render() {
    const currentYear = new Date().getFullYear();
    
    return (
      <footer>
        <p>&copy; <span id="year">{currentYear}</span> Barefoot Gardener</p>
      </footer>
    );
  }
}

export default Footer;