import React from 'react';

import 'element-theme-default';
import './assets/styles.css';

import {Route, Switch} from 'react-router-dom'
import MainPage from "./containers/MainPage";

class App extends React.Component {
    render() {
        return (
            <main>

                <Switch>
                    <Route exact path='/' component={MainPage}/>
                </Switch>
            </main>
        )
    }
}

export default App;
