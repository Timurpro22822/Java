import { useEffect } from "react";
import { useSelector } from "react-redux";
import { useDispatch } from "react-redux/es/exports";
import http from "../../http_common";
import { CategoryActionTypes, GetCategoryAction, ICategoryResponse, ICategoryState } from "../../types";

const CategoryPage = () => {

    // const { list } = useSelector((state: any) => state.category as ICategoryState);
    // const dispatch = useDispatch();

    // useEffect(() => {
    //     http.get<ICategoryResponse>("/api/categories").then((resp) => {
    //         console.log("List product server: ", resp);
    //         console.log("List: ", list);
    //         const { data } = resp;
    //         console.log("Data: ", data);

    //         const payload: ICategoryState = {
    //             list: data.data
    //         };
            
    //         const action: GetCategoryAction = {
    //             type: CategoryActionTypes.GET_CATEGORIES,
    //             payload: payload
    //         };

    //         dispatch(action);
    //     });
    // }, []);
    
    // const data = list?.map((category) =>
    //     <tr key={category.id}>
    //         <td>{category.id}</td>
    //         <td>{category.name}</td>
    //         <td>{category.description}</td>
    //         <td>{category.image}</td>
    //     </tr>
    // ) ?? [];

    return (
        <>
            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Image</th>
                    </tr>
                </thead>
                {/* <tbody>{data}</tbody> */}
            </table>
        </>
    )
}

export default CategoryPage;