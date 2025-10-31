import React, { useState } from 'react';
import './App.css';

function App() {
  const [stateName, setStateName] = useState('');
  const [breweries, setBreweries] = useState([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState('');
  const [searched, setSearched] = useState(false);

  const endpoint = "https://api.openbrewerydb.org/v1/breweries"

  const handleSubmit = async (e) => {
    e.preventDefault();
    
    if (!stateName.trim()) {
      setError('Please enter a state name');
      return;
    }

    setLoading(true);
    setError('');
    setSearched(true);

    try {
      // Format state name for API (replace spaces with underscores)
      const formattedState = stateName.trim().toLowerCase().replace(/\s+/g, '_');
      const response = await fetch(
        `${endpoint}?by_state=${formattedState}&per_page=30`
      );
      
      if (!response.ok) {
        throw new Error('Failed to fetch breweries');
      }

      const data = await response.json();
      setBreweries(data);
    } catch (err) {
      setError('Failed to fetch breweries. Please try again.');
      setBreweries([]);
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="App">
      <div className="container">
        <header className="header">
          <h1>🍺 U.S. Brewery Finder</h1>
          <p>Discover breweries in any U.S. state</p>
        </header>

        <form onSubmit={handleSubmit} className="search-form">
          <div className="form-group">
            <input
              type="text"
              value={stateName}
              onChange={(e) => setStateName(e.target.value)}
              placeholder="Enter state name (e.g., California, New York)"
              className="state-input"
              aria-label="State name"
            />
            <button type="submit" className="search-button" disabled={loading}>
              {loading ? 'Searching...' : 'Search'}
            </button>
          </div>
          {error && <p className="error-message">{error}</p>}
        </form>

        {loading && (
          <div className="loading-spinner">
            <div className="spinner"></div>
          </div>
        )}

        {!loading && searched && breweries.length === 0 && !error && (
          <p className="no-results">No breweries found for "{stateName}"</p>
        )}

        {!loading && breweries.length > 0 && (
          <div className="brewery-list">
            <h2>Breweries in {stateName}</h2>
            <div className="brewery-grid">
              {breweries.map((brewery) => (
                <div key={brewery.id} className="brewery-card">
                  <h3>{brewery.name}</h3>
                  <div className="brewery-details">
                    <p className="brewery-type">
                      <span className="label">Type:</span> 
                      <span className="value">{brewery.brewery_type}</span>
                    </p>
                    {brewery.street && (
                      <p className="brewery-address">
                        <span className="label">Address:</span>
                        <span className="value">
                          {brewery.street}<br />
                          {brewery.city}, {brewery.state} {brewery.postal_code}
                        </span>
                      </p>
                    )}
                    {brewery.phone && (
                      <p className="brewery-phone">
                        <span className="label">Phone:</span>
                        <span className="value">
                          {brewery.phone.replace(/(\d{3})(\d{3})(\d{4})/, '($1) $2-$3')}
                        </span>
                      </p>
                    )}
                    {brewery.website_url && (
                      <p className="brewery-website">
                        <span className="label">Website:</span>
                        <a 
                          href={brewery.website_url} 
                          target="_blank" 
                          rel="noopener noreferrer"
                          className="website-link"
                        >
                          Visit Website
                        </a>
                      </p>
                    )}
                  </div>
                </div>
              ))}
            </div>
          </div>
        )}
      </div>
    </div>
  );
}

export default App;
