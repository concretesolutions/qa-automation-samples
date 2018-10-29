import React from 'react';
import { shallow } from 'enzyme';
import App from './App';
import setupTests from './../setupTest';

describe('App', () => {
    const app = shallow(<App />);

    it('renders properly', () => {
        expect(app).toMatchSnapshot();
    });
    
    it('contains a connected Wallet component', () => {
        expect(app.find('Connect(Wallet)').exists()).toBe(true);
    });

    it('constains a connected loot component', () => {
        expect(app.find('Connect(Loot)').exists()).toBe(true);
    });

    it('contains a link to the coindesk price page', () => {
        expect(app.find('a').props().href).toBe('http://www.coindesk.com/price');
    });
});