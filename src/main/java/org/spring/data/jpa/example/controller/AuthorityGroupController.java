package org.spring.data.jpa.example.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.spring.data.jpa.example.domain.security.AuthorityGroup;
import org.spring.data.jpa.example.model.error.ErrorResponse;
import org.spring.data.jpa.example.service.AuthorityGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.Boolean.TRUE;
import static org.spring.data.jpa.example.domain.security.AuthorityGroup.anAuthorityGroup;
import static org.spring.data.jpa.example.model.error.ErrorResponse.anErrorResponse;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@Api(value = "/", description = "Authority Group")
public class AuthorityGroupController {

    private final AuthorityGroupService authorityGroupService;

    @Autowired
    public AuthorityGroupController(final AuthorityGroupService authorityGroupService) {
        this.authorityGroupService = authorityGroupService;
    }

    @RequestMapping(value = "/find/{id}", method = GET)
    @ApiOperation(value = "Find an Authority Group by Id")
    @ResponseStatus(OK)
    public AuthorityGroup findOne(@PathVariable final Long id) throws Exception {
        return authorityGroupService.findOne(id);
    }

    @RequestMapping(value = "/insert", method = GET)
    @ApiOperation(value = "Insert an Authority Group")
    @ResponseStatus(NO_CONTENT)
    public void insert() throws Exception {
        final AuthorityGroup authorityGroup = anAuthorityGroup()
                .withCreatedBy("SYSTEM")
                .withName("ROLE_ADMINISTRATOR")
                .withDescription("DESCRIPTION")
                .withEnabled(TRUE)
                .build();

        authorityGroupService.insert(authorityGroup);
    }

    @RequestMapping(value = "/update/{id}", method = GET)
    @ApiOperation(value = "Update an Authority Group")
    @ResponseStatus(NO_CONTENT)
    public void update(@PathVariable final Long id) throws Exception {
        final AuthorityGroup authorityGroup = authorityGroupService.findOne(id);

        final AuthorityGroup updateAuthorityGroup = anAuthorityGroup(authorityGroup)
                .withName("ROLE_TESTING")
                .build();

        authorityGroupService.update(updateAuthorityGroup);
    }

    @RequestMapping(value = "/delete/{id}", method = GET)
    @ApiOperation(value = "Delete an Authority Group")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable final Long id) throws Exception {
        final AuthorityGroup authorityGroup = authorityGroupService.findOne(id);

        authorityGroupService.delete(authorityGroup);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(final Exception exception) {
        final ErrorResponse errorResponse = anErrorResponse()
                .withErrorCode(INTERNAL_SERVER_ERROR.value())
                .withMessage(exception.getMessage())
                .build();
        return new ResponseEntity<>(errorResponse, INTERNAL_SERVER_ERROR);
    }

}
