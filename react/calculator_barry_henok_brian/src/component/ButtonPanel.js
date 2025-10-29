import Button from "./Button";
import React from "react";
import PropTypes from "prop-types";

import "./ButtonPanel.css";

export default class ButtonPanel extends React.Component {
  createButton({ buttonName, orange, wide }) {
    return (
      <Button
        clickHandler={this.props.clickHandler}
        buttonName={buttonName}
        orange={orange}
        wide={wide}
      />
    );
  }
  render() {
    return (
      <div className="component-button-panel">
        <div>
          {this.createButton({ buttonName: "AC" })}
          {this.createButton({ buttonName: "+/-" })}
          {this.createButton({ buttonName: "%" })}
          {this.createButton({ buttonName: "÷", orange: true })}
        </div>
        <div>
          {this.createButton({ buttonName: "7" })}
          {this.createButton({ buttonName: "8" })}
          {this.createButton({ buttonName: "9" })}
          {this.createButton({ buttonName: "x", orange: true })}
        </div>
        <div>
          {this.createButton({ buttonName: "4" })}
          {this.createButton({ buttonName: "5" })}
          {this.createButton({ buttonName: "6" })}
          {this.createButton({ buttonName: "-", orange: true })}
        </div>
        <div>
          {this.createButton({ buttonName: "1" })}
          {this.createButton({ buttonName: "2" })}
          {this.createButton({ buttonName: "3" })}
          {this.createButton({ buttonName: "+", orange: true })}
        </div>
        <div>
          {this.createButton({ buttonName: "0", wide: true })}
          {this.createButton({ buttonName: "." })}
          {this.createButton({ buttonName: "=", orange: true })}
        </div>
      </div>
    );
  }
}
