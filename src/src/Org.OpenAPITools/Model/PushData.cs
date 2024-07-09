/*
 * Static OpenAPI document of Push API resource
 *
 * Push API resources Open API documentation
 *
 * The version of the OpenAPI document: 0.3.15-sdk.5
 * Generated by: https://github.com/openapitools/openapi-generator.git
 */


using System;
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.IO;
using System.Runtime.Serialization;
using System.Text;
using System.Text.RegularExpressions;
using Newtonsoft.Json;
using Newtonsoft.Json.Converters;
using Newtonsoft.Json.Linq;
using System.ComponentModel.DataAnnotations;
using OpenAPIDateConverter = Org.OpenAPITools.Client.OpenAPIDateConverter;

namespace Org.OpenAPITools.Model
{
    /// <summary>
    /// PushData
    /// </summary>
    [DataContract(Name = "PushData")]
    public partial class PushData : IValidatableObject
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="PushData" /> class.
        /// </summary>
        /// <param name="attributes">attributes.</param>
        /// <param name="date">date.</param>
        /// <param name="key">key.</param>
        /// <param name="periodFrom">periodFrom.</param>
        /// <param name="periodTo">periodTo.</param>
        /// <param name="unit">unit.</param>
        /// <param name="value">value.</param>
        public PushData(List<PushDataAttribute> attributes = default(List<PushDataAttribute>), string date = default(string), string key = default(string), string periodFrom = default(string), string periodTo = default(string), string unit = default(string), float value = default(float))
        {
            this.Attributes = attributes;
            this.Date = date;
            this.Key = key;
            this.PeriodFrom = periodFrom;
            this.PeriodTo = periodTo;
            this.Unit = unit;
            this.Value = value;
        }

        /// <summary>
        /// Gets or Sets Attributes
        /// </summary>
        [DataMember(Name = "attributes", EmitDefaultValue = false)]
        public List<PushDataAttribute> Attributes { get; set; }

        /// <summary>
        /// Gets or Sets Date
        /// </summary>
        [DataMember(Name = "date", EmitDefaultValue = false)]
        public string Date { get; set; }

        /// <summary>
        /// Gets or Sets Key
        /// </summary>
        [DataMember(Name = "key", EmitDefaultValue = false)]
        public string Key { get; set; }

        /// <summary>
        /// Gets or Sets PeriodFrom
        /// </summary>
        [DataMember(Name = "periodFrom", EmitDefaultValue = false)]
        public string PeriodFrom { get; set; }

        /// <summary>
        /// Gets or Sets PeriodTo
        /// </summary>
        [DataMember(Name = "periodTo", EmitDefaultValue = false)]
        public string PeriodTo { get; set; }

        /// <summary>
        /// Gets or Sets Unit
        /// </summary>
        [DataMember(Name = "unit", EmitDefaultValue = false)]
        public string Unit { get; set; }

        /// <summary>
        /// Gets or Sets Value
        /// </summary>
        [DataMember(Name = "value", EmitDefaultValue = false)]
        public float Value { get; set; }

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class PushData {\n");
            sb.Append("  Attributes: ").Append(Attributes).Append("\n");
            sb.Append("  Date: ").Append(Date).Append("\n");
            sb.Append("  Key: ").Append(Key).Append("\n");
            sb.Append("  PeriodFrom: ").Append(PeriodFrom).Append("\n");
            sb.Append("  PeriodTo: ").Append(PeriodTo).Append("\n");
            sb.Append("  Unit: ").Append(Unit).Append("\n");
            sb.Append("  Value: ").Append(Value).Append("\n");
            sb.Append("}\n");
            return sb.ToString();
        }

        /// <summary>
        /// Returns the JSON string presentation of the object
        /// </summary>
        /// <returns>JSON string presentation of the object</returns>
        public virtual string ToJson()
        {
            return Newtonsoft.Json.JsonConvert.SerializeObject(this, Newtonsoft.Json.Formatting.Indented);
        }

        /// <summary>
        /// To validate all properties of the instance
        /// </summary>
        /// <param name="validationContext">Validation context</param>
        /// <returns>Validation Result</returns>
        IEnumerable<System.ComponentModel.DataAnnotations.ValidationResult> IValidatableObject.Validate(ValidationContext validationContext)
        {
            yield break;
        }
    }

}
