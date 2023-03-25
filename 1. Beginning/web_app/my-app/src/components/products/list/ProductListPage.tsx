import axios from "axios";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { APP_ENV } from "../../../env";
import ModalDelete from "../delete/ProductDelete";
import { IProductItem } from "../types";
import "./style.css";

const ProductsListPage = () => {
  const [list, setList] = useState<Array<IProductItem>>([]);

  useEffect(() => {
    axios
      .get<Array<IProductItem>>(`${APP_ENV.REMOTE_HOST_NAME}api/products`)
      .then((resp) => {
        const { data } = resp;
        setList(resp.data);
        console.log("Server result", resp);
      });
  }, []);
  
  const deleteProductHandler = (id: number) => {
    axios.delete(`${APP_ENV.REMOTE_HOST_NAME}api/products/${id}`)
      .then(resp =>{
        setList(list.filter(x=>x.id!==id));
      });
  };
  const content = list.map((p) => (
    <div key={p.id}>
      <div className="group relative">
        <div className="relative h-80 w-full overflow-hidden rounded-lg bg-white group-hover:opacity-75 sm:aspect-w-2 sm:aspect-h-1 sm:h-64 lg:aspect-w-1 lg:aspect-h-1">
          <img
            src={APP_ENV.REMOTE_HOST_NAME + "files/600_" + p.files[0]}
            alt={p.name}
            className="picture-container"
          />
        </div>
        <h3 className="mt-6 text-sm text-gray-500">
          <a href="">
            <span className="absolute inset-0" />
            {p.name}
          </a>
        </h3>
        <p className="text-base font-semibold text-gray-900">{p.price}&nbsp;грн.</p>
      </div>
      <div className="mt-2">
        <Link to={`/products/edit/${p.id}`} className="py-2 px-4 bg-white border border-gray-200 text-gray-600 rounded hover:bg-gray-100 active:bg-gray-200 disabled:opacity-50">
          Edit
        </Link>
        <ModalDelete
          id={p.id}
          title="Deleting"
          text={`Are you sure you wanna delete: '${p.name}'`}
          deleteFunc={deleteProductHandler} />
      </div>
      
    </div>
  ));
  return (
    <>
      <div className="bg-gray-100">
        <div className="mx-auto max-w-7xl px-4 sm:px-6 lg:px-8">
          <div className="mx-auto max-w-2xl py-2 sm:py-5 lg:max-w-none lg:py-10">
            <h2 className="text-2xl font-bold text-gray-900">List of products</h2>
            <div className="py-2">
              <Link
                to="/products/create"
                className="text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 mr-2 mb-2 dark:bg-blue-600 dark:hover:bg-blue-700 focus:outline-none dark:focus:ring-blue-800"
              >
                Додати продукт
              </Link>
            </div>

            <div className="mt-6 space-y-12 lg:grid lg:grid-cols-3 lg:gap-x-6 lg:space-y-0">
              {content}
            </div>
          </div>
        </div>
      </div>
    </>
  );
}

export default ProductsListPage;
