import { composeWithDevTools } from "@redux-devtools/extension";
import { applyMiddleware, combineReducers, createStore } from "redux";
import thunk from "redux-thunk";
import { categoryReducer } from "../categoryReduser";

export const rootReducer = combineReducers({
    category: categoryReducer
});

export const store = createStore(rootReducer,
    composeWithDevTools(applyMiddleware(thunk)))