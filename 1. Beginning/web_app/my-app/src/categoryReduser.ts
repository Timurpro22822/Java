import { CategoryActions, CategoryActionTypes, ICategoryItem, ICategoryState } from "./types";

const initialState : Array<ICategoryItem> = [
    //TEST
    // {
    //     id: 1,
    //     name: "test12",
    //     description: "desc for test12",
    //     image: "test.jpg"
    // }
];

// Простий редюсер
export const categoryReducer = (state = initialState, action: any) => {
    console.log("Action: ", action);
    switch(action.type)
    {
        case CategoryActionTypes.GET_CATEGORIES: {
            const payload : Array<ICategoryItem> = action.payload as [];
            return payload;
        }
    }
    return state;
}