import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import '../styles/home.css';

class Home extends Component {
  componentDidMount() {
    document.title = 'Home | Barefoot Gardener';
  }

  render() {
    return (
      <main id="main-content">
        <section id="hero">
          <div className="hero-overlay"></div>
          <div className="hero-text">
            <h2>The Yard of your Dreams</h2>
          </div>
        </section>

        <section className="page-content">
          <div>
            <h2>Milwaukee's Leading Boutique Landscaper</h2>
            <p>
              For over 5 years, the Barefoot Gardener has been recognized as the
              trusted neighborhood landscaping solution. Offering both
              transformative landscaping and routine maintenance plans, we
              specialize in making your dream yard a reality. Your home is an
              extension of you - your personality, your values, your pride. Let
              the Barefoot Gardeer help you extend it to your yard as well!
              Explore our{' '}
              <Link to="/about">About page</Link> to learn more about our
              sustainable, low-maintenance approach!
            </p>
          </div>
        </section>
      </main>
    );
  }
}

export default Home;