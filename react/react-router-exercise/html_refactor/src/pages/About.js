import React, { Component } from 'react';
import '../styles/about.css';

class About extends Component {
  componentDidMount() {
    document.title = 'About | Barefoot Gardener';
  }

  render() {
    return (
      <main id="main-content">
        <section className="page-content">
          <div>
            <h2>My Story</h2>
            <p>
              Hi! I am Maya, Milwaukee's Barefoot Gardener. With over 5 years of
              immersive landscaping experience, I have established a reputation
              for getting down and dirty - so you don't have to! Sustainability is
              the central focus of my work. I have established a rich
              understanding of the best plants, shrubs, and vegetation for our
              specific Milwaukee climate, and what each plant needs to thrive. I
              work with you to understand your specific wants and needs to develop
              a long-lasting, personalized action plan to transform your yard.
            </p>
          </div>
        </section>
        
        <section className="page-content">
          <div>
            <h2>Services</h2>
            <p>
              Whether you want to transform your yard completely or simply need
              help maintaining your current landscape, the Barefoot Gardener is
              your solution. Reach out today with your yard projects and get your
              To-Do list To-Done! We offer:
            </p>
            <div className="services">
              <div className="renovation-services">
                <h3>Landscaping</h3>
                <ul>
                  <li>Yard Analysis</li>
                  <li>Veggie Garden Setup</li>
                  <li>Landscaping</li>
                  <li>Paving Stone Walkway Installation</li>
                </ul>
              </div>
              <div className="maintenance-services">
                <h3>Maintenance</h3>
                <ul>
                  <li>Weeding</li>
                  <li>Garden Bed Maintenance</li>
                  <li>Raking</li>
                  <li>Mowing</li>
                  <li>Disposal of yard waste</li>
                  <li>Trimming and pruning</li>
                </ul>
              </div>
            </div>
          </div>
        </section>
      </main>
    );
  }
}

export default About;