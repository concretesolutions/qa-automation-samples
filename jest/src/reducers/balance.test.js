import balanceReducer from './balance';
import balanceReducer2 from './balance';
import * as constants from '../actions/constants';
import { withdraw } from '../actions/balance';

describe('balanceReducer', () => {

    describe('when initializing', () => {
        const balance = 10;

        it('sets a balance', () => {
            expect(balanceReducer(undefined, { type: constants.SET_BALANCE, balance}))
            .toEqual(balance);
        });
    
        describe('then re-initalizing', () => {
            it('read the balance from cookies', () => {
                expect(balanceReducer2(undefined, {})).toEqual(balance);
            });
        });
    });
    

    it('deposits into the balance', () => {
        const deposit = 10;
        const initialState = 5;

        expect(balanceReducer(initialState, { type: constants.DEPOSIT, deposit }))
        .toEqual(initialState + deposit);
    });

    it('whithdraws from the balance', () => {
        const whithdraw = 10;
        const initialState = 20;

        expect(balanceReducer(initialState, {type: constants.WITHDRAW, whithdraw }))
        .toEqual(initialState - withdraw);
    });
});