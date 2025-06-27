import React, { useState, useEffect } from 'react';

import Header from './Header';
import Sidebar from './Sidebar';
import FormPreview from './FormPreview';
import SortableFieldList from './SortableFieldList';
import { initialFields,initialValues, dataFields, customFields } from '../data/fielddata';

const FormBuilder = () => {
  const [formTitle, setFormTitle] = useState("Demo Form");
  const [formDescription, setFormDescription] = useState("This is form description");
  const [formPages, setFormPages] = useState([
    [{ id: 'name', type: 'text', label: 'Name' },
    { id: 'email', type: 'email', label: 'Email' }],
  ]);
  // const [formFields, setFormFields] = useState([
  //    { id: 'name-field', type: 'text', label: 'Name' },
  //    { id: 'email-field', type: 'email', label: 'Email' },
  //    { id: 'gender-field', type: 'radio', label: 'Gender', options: ['Male', 'Female'] }
  //  ]);
  const [companyLogo, setCompanyLogo] = useState(null);
  const [currentPage, setCurrentPage] = useState(0);
  const [pendingPageAdd, setPendingPageAdd] = useState(false);

  useEffect(() => {
    if (pendingPageAdd) {
      setCurrentPage(formPages.length - 1);
      setPendingPageAdd(false);
    }
  }, [formPages, pendingPageAdd]);


  const onDrop = (field) => {
    const newField = { ...field };
    // console.log("🔽 Dropped field:", newField); 

    setFormPages((prevPages) => {
      const updatedPages = [...prevPages];
      updatedPages[currentPage] = [...updatedPages[currentPage], newField];
      // console.log("✅ Updated Pages:", updatedPages); 

      return updatedPages;
    });
  };


  const handleDeleteField = (fieldId) => {
    setFormPages((prevPages) => {
      const updatedPages = [...prevPages];
      updatedPages[currentPage] = updatedPages[currentPage].filter(field => field.id !== fieldId);
      return updatedPages;
    });
    
  };

  const setFieldsForPage = (updatedFields) => {
    console.log("Updating fields:", updatedFields);

    setFormPages((prevPages) => {
      const newPages = [...prevPages];
      newPages[currentPage] = updatedFields;
      return newPages;
    });

  };

  const addPage = () => {
    setFormPages((prevPages) => [...prevPages, []]);
    setPendingPageAdd(true);
  };

  const removePage = () => {
    if (formPages.length > 1) {
      setFormPages((prevPages) => {
        const newPages = prevPages.filter((_, index) => index !== currentPage);
        return newPages;
      });
      setCurrentPage((prevPage) => Math.max(0, prevPage - 1));
    }
  };

  const nextPage = () => {
    if (currentPage < formPages.length - 1) {
      setCurrentPage((prevPage) => prevPage + 1);
    }
  };



  const prevPage = () => {
    if (currentPage > 0) {
      setCurrentPage((prevPage) => prevPage - 1);
    }
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    
    const submittedValues = {};
    formPages.forEach(page => {
      page.forEach(field => {
        submittedValues[field.id] = field.value || "";
      });
    });
  
    console.log("Form submitted with values:", submittedValues);
  };

  // const handleFieldsChange = (updatedFields) => {
  //   // console.log("Updating fields:", updatedFields); // Debugging
  //   setFieldsForPage(updatedFields);
  //   setFormPages((prevPages) => {
  //     const newPages = [...prevPages];
  //     const currentPageFields = [...newPages[currentPage]];
    
  //     // Find the field and update its value
  //     const updatedFields = currentPageFields.map(field => 
  //       field.id === fieldId ? { ...field, value } : field
  //     );
  //     newPages[currentPage] = [...updatedFields];
  //     return newPages;
  //   });
  // };
  
  // console.log("Passing handleFieldChange to SortableFieldList:", handleFieldsChange);
  // const handleFieldValueChange = (fieldId, value) => {
  //   setFormPages((prevPages) => {
  //     const updatedPages = [...prevPages];
  //     updatedPages[currentPage] = updatedPages[currentPage].map(field => 
  //       field.id === fieldId ? { ...field, value } : field
  //     );
  //     return updatedPages;
  //   });
  // };

  const getFormValues = () => {
    const allFieldIds = new Set();
 
    formPages.forEach((page) => {
      page.forEach((field) => {
        allFieldIds.add(field.id);
      });
    });
    const formValues = { ...initialValues };
 
    allFieldIds.forEach((fieldId) => {
      if (!(fieldId in formValues)) {
        const fieldType = getFieldType(fieldId);
 
        if (fieldType === "checkbox") {
          formValues[fieldId] = false;
        } else if (fieldType === "file") {
          formValues[fieldId] = null;
        } else {
          formValues[fieldId] = "";
        }
      }
    });
    return formValues;
  };

  const getFieldType = (fieldId) => {
    for (const page of formPages) {
      for (const field of page) {
        if (field.id === fieldId) {
          return field.type;
        }
      }
    }
    return "text";
  };

 
  return (

        <form initialValues={getFormValues()} onSubmit={handleSubmit}  className="flex flex-col min-h-screen bg-white">
          <Header formTitle={formTitle} />

         
          <div className="flex flex-1 p-5">
            <div className="w-1/4 pr-4">
              <Sidebar
                onDrop={onDrop}
                dataFields={dataFields}
                initialFields={initialFields}
                customFields={customFields}
              />
            </div>
            <main className="w-3/4">
            {/* console.log("Passing handleFieldChange to FormPreview:", setFieldsForPage); */}

              <FormPreview
                formTitle={formTitle}
                formDescription={formDescription}
                formPages={formPages}
                currentPage={currentPage}
                onDrop={onDrop}
                setFieldsForPage={setFieldsForPage}
                onDelete = {handleDeleteField}
                handleFieldsChange={setFieldsForPage} 
                // onFieldValueChange={handleFieldValueChange}  // Add this prop
 
                >

                <SortableFieldList 
                fields={formPages[currentPage] || []} 
                onFieldsChange={setFieldsForPage}  
                // onDelete={(id) => setFields(fields.filter(field => field.id !== id))}
                onDelete={handleDeleteField}
                
                // onFieldValueChange={handleFieldValueChange}  // Add this prop


                />

                </FormPreview>


              <div className="flex justify-between mt-4">

                <button onClick={prevPage} disabled={currentPage === 0} className="px-2 py-1 border-2 border-gray-500 text-gray-500 rounded hover:bg-gray-500 hover:text-white transition">
                  Previous
                </button>

                <div className="flex items-center gap-4">
                  <button onClick={addPage} className="px-2 py-1 border-2 border-blue-500 text-blue-500 rounded hover:bg-blue-500 hover:text-white transition">
                    Add Page
                  </button>

                  <button onClick={removePage} disabled={formPages.length === 1} className="px-2 py-1 border-2 border-red-500 text-red-500 rounded hover:bg-red-500 hover:text-white transition">
                    Remove Page
                  </button>
                </div>

                <button onClick={nextPage} disabled={currentPage >= formPages.length - 1} className="px-2 py-1 border-2 border-gray-500 text-gray-500 rounded hover:bg-gray-500 hover:text-white transition">
                  Next
                </button>
              </div>
              
              <button
                type="submit"
                // disabled={isSubmitting}
                className="mt-4 px-4 py-2 bg-blue-500 text-white rounded"
              >
                Submit Form
              </button>

               <div className="mt-4 p-4 bg-gray-100 rounded">
                <h3 className="font-bold">Form State (Debug):</h3>
                <div>
                  <pre className="text-xs mt-2">{JSON.stringify({formPages}, null, 2)}</pre>
                </div>
              </div>
              
            </main>
          </div>
        
        </form>
      )}
    
  


export default FormBuilder;



// import React, { useState, useEffect } from 'react';
// import Header from './Header';
// import Sidebar from './Sidebar';
// import FormPreview from './FormPreview';
// import SortableFieldList from './SortableFieldList';
// import { initialFields, initialValues, dataFields, customFields } from '../data/fielddata';

// const FormBuilder = () => {
//   const [formTitle, setFormTitle] = useState("Demo Form");
//   const [formDescription, setFormDescription] = useState("This is form description");
//   const [formPages, setFormPages] = useState([
//     [{ id: 'name', type: 'text', label: 'Name' },
//     { id: 'email', type: 'email', label: 'Email' }],
//   ]);
//   const [companyLogo, setCompanyLogo] = useState(null);
//   const [currentPage, setCurrentPage] = useState(0);
//   const [pendingPageAdd, setPendingPageAdd] = useState(false);
//   const [formValues, setFormValues] = useState({}); // Add this to track form values

//   useEffect(() => {
//     if (pendingPageAdd) {
//       setCurrentPage(formPages.length - 1);
//       setPendingPageAdd(false);
//     }
//   }, [formPages, pendingPageAdd]);

//   // Initialize form values when pages change
//   useEffect(() => {
//     setFormValues(getFormValues());
//   }, [formPages]);

//   const onDrop = (field) => {
//     const newField = { ...field };

//     setFormPages((prevPages) => {
//       const updatedPages = [...prevPages];
//       updatedPages[currentPage] = [...updatedPages[currentPage], newField];
//       return updatedPages;
//     });
//   };

//   const handleDeleteField = (fieldId) => {
//     setFormPages((prevPages) => {
//       const updatedPages = [...prevPages];
//       updatedPages[currentPage] = updatedPages[currentPage].filter(field => field.id !== fieldId);
//       return updatedPages;
//     });
    
//     // Also clean up the form values
//     setFormValues(prev => {
//       const newValues = { ...prev };
//       delete newValues[fieldId];
//       return newValues;
//     });
//   };

//   const setFieldsForPage = (updatedFields) => {
//     setFormPages((prevPages) => {
//       const newPages = [...prevPages];
//       newPages[currentPage] = updatedFields;
//       return newPages;
//     });
//   };

//   // Add this function to handle field value changes
//   const handleFieldValueChange = (fieldId, value) => {
//     setFormValues(prev => ({
//       ...prev,
//       [fieldId]: value
//     }));
    
//     // Also update the field value in the formPages state
//     setFormPages(prevPages => {
//       const newPages = [...prevPages];
//       newPages[currentPage] = newPages[currentPage].map(field => 
//         field.id === fieldId ? { ...field, value } : field
//       );
//       return newPages;
//     });
//   };

//   const addPage = () => {
//     setFormPages((prevPages) => [...prevPages, []]);
//     setPendingPageAdd(true);
//   };

//   const removePage = () => {
//     if (formPages.length > 1) {
//       // Save field IDs to remove
//       const fieldsToRemove = formPages[currentPage].map(field => field.id);
      
//       setFormPages((prevPages) => {
//         const newPages = prevPages.filter((_, index) => index !== currentPage);
//         return newPages;
//       });
      
//       // Remove values for deleted fields
//       setFormValues(prev => {
//         const newValues = { ...prev };
//         fieldsToRemove.forEach(id => delete newValues[id]);
//         return newValues;
//       });
      
//       setCurrentPage((prevPage) => Math.max(0, prevPage - 1));
//     }
//   };

//   const nextPage = () => {
//     if (currentPage < formPages.length - 1) {
//       setCurrentPage((prevPage) => prevPage + 1);
//     }
//   };

//   const prevPage = () => {
//     if (currentPage > 0) {
//       setCurrentPage((prevPage) => prevPage - 1);
//     }
//   };

//   const handleSubmit = (event) => {
//     event.preventDefault();
//     console.log("Form submitted with values:", formValues);
//   };

//   const getFormValues = () => {
//     const allFieldIds = new Set();
//     const values = { ...initialValues };
 
//     formPages.forEach((page) => {
//       page.forEach((field) => {
//         allFieldIds.add(field.id);
//       });
//     });
 
//     allFieldIds.forEach((fieldId) => {
//       if (!(fieldId in values)) {
//         const fieldType = getFieldType(fieldId);
 
//         if (fieldType === "checkbox") {
//           values[fieldId] = false;
//         } else if (fieldType === "radio") {
//           values[fieldId] = "";
//         } else if (fieldType === "select" || fieldType === "dropdown") {
//           values[fieldId] = "";
//         } else if (fieldType === "rating") {
//           values[fieldId] = 0;
//         } else if (fieldType === "file") {
//           values[fieldId] = null;
//         } else {
//           values[fieldId] = "";
//         }
//       }
//     });
    
//     return values;
//   };

//   const getFieldType = (fieldId) => {
//     for (const page of formPages) {
//       for (const field of page) {
//         if (field.id === fieldId) {
//           return field.type;
//         }
//       }
//     }
//     return "text";
//   };

//   // Combine initial values with current form values
//   const currentFormValues = {
//     ...getFormValues(),
//     ...formValues
//   };

//   return (
//     <form onSubmit={handleSubmit} className="flex flex-col min-h-screen bg-white">
//       <Header formTitle={formTitle} />
      
//       <div className="flex flex-1 p-5">
//         <div className="w-1/4 pr-4">
//           <Sidebar
//             onDrop={onDrop}
//             dataFields={dataFields}
//             initialFields={initialFields}
//             customFields={customFields}
//           />
//         </div>
//         <main className="w-3/4">
//           <FormPreview
//             formTitle={formTitle}
//             formDescription={formDescription}
//             formPages={formPages}
//             currentPage={currentPage}
//             onDrop={onDrop}
//             setFieldsForPage={setFieldsForPage}
//             onDelete={handleDeleteField}
//             formValues={currentFormValues}
//             onFieldValueChange={handleFieldValueChange}
//           >
//             <SortableFieldList 
//               fields={formPages[currentPage] || []} 
//               onFieldsChange={setFieldsForPage}
//               onDelete={handleDeleteField}
//               formValues={currentFormValues}
//               onFieldValueChange={handleFieldValueChange}
//             />
//           </FormPreview>

//           <div className="flex justify-between mt-4">
//             <button 
//               type="button"
//               onClick={prevPage} 
//               disabled={currentPage === 0} 
//               className="px-2 py-1 border-2 border-gray-500 text-gray-500 rounded hover:bg-gray-500 hover:text-white transition"
//             >
//               Previous
//             </button>

//             <div className="flex items-center gap-4">
//               <button 
//                 type="button"
//                 onClick={addPage} 
//                 className="px-2 py-1 border-2 border-blue-500 text-blue-500 rounded hover:bg-blue-500 hover:text-white transition"
//               >
//                 Add Page
//               </button>

//               <button 
//                 type="button"
//                 onClick={removePage} 
//                 disabled={formPages.length === 1} 
//                 className="px-2 py-1 border-2 border-red-500 text-red-500 rounded hover:bg-red-500 hover:text-white transition"
//               >
//                 Remove Page
//               </button>
//             </div>

//             <button 
//               type="button"
//               onClick={nextPage} 
//               disabled={currentPage >= formPages.length - 1} 
//               className="px-2 py-1 border-2 border-gray-500 text-gray-500 rounded hover:bg-gray-500 hover:text-white transition"
//             >
//               Next
//             </button>
//           </div>
          
//           <button
//             type="submit"
//             className="mt-4 px-4 py-2 bg-blue-500 text-white rounded"
//           >
//             Submit Form
//           </button>

//           <div className="mt-4 p-4 bg-gray-100 rounded">
//             <h3 className="font-bold">Form State (Debug):</h3>
//             <div>
//               <pre className="text-xs mt-2">{JSON.stringify({ formPages, formValues }, null, 2)}</pre>
//             </div>
//           </div>
//         </main>
//       </div>
//     </form>
//   );
// };

// export default FormBuilder;
