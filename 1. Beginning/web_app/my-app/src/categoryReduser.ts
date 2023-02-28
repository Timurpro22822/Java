import { CategoryActions, CategoryActionTypes, ICategoryState } from "./types";

const initialState : ICategoryState = {
    list: []
};

export const categoryReducer = (state = initialState, action: CategoryActions) : ICategoryState => {
    switch(action.type)
    {
        case CategoryActionTypes.GET_CATEGORIES: {
            return {
                ...state,
                list: action.payload.list
            }
        }
    }
    return state;
}