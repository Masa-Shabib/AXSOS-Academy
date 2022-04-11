import React from "react"

class PersonCard extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            old: this.props.age
        };
    }
    add = () => {
        this.setState({ old: this.state.old+1 });
        
    }
    render() {
        return (
            <div>
                <h1>{ this.props.lastName }, { this.props.firstName }</h1>
                <p> Age: { this.state.old }</p>
                <p> Hair Color: { this.props.color }</p>
                <button onClick={ this.add }>Birthday Button for { this.props.firstName } { this.props.lastName }</button>
            </div>
        );
    }
}
export default PersonCard;