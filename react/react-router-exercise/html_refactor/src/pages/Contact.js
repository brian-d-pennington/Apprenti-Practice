import React, { Component } from 'react';
import '../styles/contact.css';

class Contact extends Component {
  constructor(props) {
    super(props);
    this.state = {
      name: '',
      email: '',
      message: ''
    };
  }

  componentDidMount() {
    document.title = 'Contact | Barefoot Gardener';
  }

  handleChange = (event) => {
    this.setState({
      [event.target.name]: event.target.value
    });
  }

  handleSubmit = (event) => {
    event.preventDefault();
    // Handle form submission here
    console.log('Form submitted:', this.state);
    // Form submission logic would go here
  }

  render() {
    return (
      <main id="main-content">
        <section aria-labelledby="contact-heading" className="page-content">
          <div>
            <h2 id="contact-heading">Get in Touch</h2>

            <form id="contact-form" onSubmit={this.handleSubmit}>
              <div className="name-email-inline">
                <div>
                  <label htmlFor="name">Name</label>
                  <input
                    type="text"
                    id="name"
                    name="name"
                    placeholder="Jane Doe"
                    value={this.state.name}
                    onChange={this.handleChange}
                    required
                  />
                </div>
                <div>
                  <label htmlFor="email">E-mail</label>
                  <input
                    type="email"
                    id="email"
                    name="email"
                    placeholder="jane@example.com"
                    value={this.state.email}
                    onChange={this.handleChange}
                    required
                  />
                </div>
              </div>
              <div className="message-input-container">
                <label htmlFor="message">Message</label>
                <textarea
                  id="message"
                  name="message"
                  rows="6"
                  placeholder="How can we help you?"
                  value={this.state.message}
                  onChange={this.handleChange}
                  required
                ></textarea>
              </div>
              <button type="submit">Send Message</button>
            </form>
          </div>
        </section>

        <section aria-labelledby="details-heading" className="page-content">
          <div className="contact-details">
            <h2 id="details-heading">Contact Details</h2>
            <p><strong>Maya Rose</strong></p>
            <address>123 Snail Street Milwaukee, WI 53207</address>
            <p>
              <a href="mailto:barefoot-gardener@google.com">barefoot-gardener@google.com</a>
            </p>
            <p>
              <a href="tel:+1234567890">+1 (234) 567-890</a>
            </p>
          </div>
        </section>
      </main>
    );
  }
}

export default Contact;