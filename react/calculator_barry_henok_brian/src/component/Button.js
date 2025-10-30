import React from "react";
import PropTypes from "prop-types";
import "./Button.css";

export default class Button extends React.Component {
  render() {
    return (
      <div
        className={`component-button${this.props.orange ? " orange" : ""}${this.props.wide ? " wide" : ""}`}
      >
        <button onClick={() => this.props.clickHandler(this.props.buttonName)}>
          {this.props.buttonName}
        </button>
      </div>
    );
  }
}
